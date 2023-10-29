import { CartService } from './../../services/cart.service';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from 'src/app/common/cart-item';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {

  products:Product[] = [];
  currenCategoryId:number = 1;
  previousCategoryId:number = 1;
  searchMode:boolean = false;

  thePageNumber: number = 1;
  thePageSize: number = 5;
  theTotalElements: number = 0;

  previousKeword:string = "";

  constructor(private productService:ProductService,
              private route:ActivatedRoute,
              private cartService:CartService){}

  ngOnInit(){
     this.route.paramMap.subscribe(() =>{
       this.listProducts();
     })
  }

  listProducts(){

    this.searchMode = this.route.snapshot.paramMap.has('keyword');
    if(this.searchMode){
      this.handleSearchProducts();
    }
    else{
      this.handleListProducts();
    }

  }



  // handleListProducts(){
  //   const categoryId:boolean = this.route.snapshot.paramMap.has('id');

  //   if(categoryId){
  //     this.currenCategoryId = +this.route.snapshot.paramMap.get('id')!;
  //   }else{
  //     this.currenCategoryId = 1;
  //   }

  //   if(this.previousCategoryId != this.currenCategoryId){
  //     this.currenCategoryId = 1;
  //   }

  //   this.previousCategoryId = this.currenCategoryId;
  //   console.log(`currentCategoryId=${this.currenCategoryId}, thePageNumber=${this.thePageNumber}`)

  //   this.productService.getProductListPaginate(this.currenCategoryId,
  //                                              this.thePageNumber - 1,
  //                                              this.thePageSize).subscribe({
  //     next:res =>{
  //       this.processResult();
  //       // this.products = res.content;
  //       // this.thePageNumber = res.number + 1;
  //       // this.thePageSize = res.size;
  //       // this.theTotalElements = res.totalElements;
  //     },
  //     error:err =>{

  //     }
  //   })
  // }


  handleListProducts(){
    const categoryId:boolean = this.route.snapshot.paramMap.has('id');

    if(categoryId){
      this.currenCategoryId = +this.route.snapshot.paramMap.get('id')!;
    }else{
      this.currenCategoryId = 1;
    }

    if(this.previousCategoryId != this.currenCategoryId){
      this.currenCategoryId = 1;
    }

    this.previousCategoryId = this.currenCategoryId;
    console.log(`currentCategoryId=${this.currenCategoryId}, thePageNumber=${this.thePageNumber}`)

    this.productService.getProductListPaginate(this.currenCategoryId,
                                               this.thePageNumber - 1,
                                               this.thePageSize).subscribe(this.processResult())
  }



  handleSearchProducts(){
     const theKeyword = this.route.snapshot.paramMap.get('keyword')!;

     if(this.previousKeword != theKeyword){
        this.thePageNumber = 1;
     }

     this.previousKeword = theKeyword;

     this.productService.searchProductsPaginate(theKeyword,
                                        this.thePageNumber - 1,
                                        this.thePageSize).subscribe(this.processResult())
  }




  addToCart(product:Product){

    console.log(`adding to cart: ${product.name} ${product.unitPrice}`)

    const theCartItem = new CartItem(product)
    this.cartService.addToCart(theCartItem);

  }




  updatePageSize(pageSize:string){
    this.thePageSize = +pageSize;
    this.thePageNumber = 1;
    this.listProducts();
  }


  processResult(){
    return (res:any) =>{
        this.products = res.content;
        this.thePageNumber = res.number + 1;
        this.thePageSize = res.size;
        this.theTotalElements = res.totalElements;
    };
  }






}
