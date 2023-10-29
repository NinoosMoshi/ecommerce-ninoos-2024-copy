import { Component } from '@angular/core';
import { Category } from 'src/app/common/category';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-category-menu',
  templateUrl: './category-menu.component.html',
  styleUrls: ['./category-menu.component.css']
})
export class CategoryMenuComponent {

  categories:Category[] = [];

  constructor(private productService:ProductService){}


  ngOnInit(){
     this.listCategories();
  }


  listCategories(){
    this.productService.getCategories().subscribe({
      next:res =>{
        this.categories = res
      },
      error:err =>{

      }
    })
  }


}
