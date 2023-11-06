import { Component } from '@angular/core';
import { OrderHistory } from 'src/app/common/order-history';
import { OrderHistoryService } from 'src/app/services/order-history.service';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent {

  orderHistoryList: OrderHistory[] = [];
  storage: Storage = sessionStorage;

  thePageNumber: number = 1;
  thePageSize: number = 5;
  theTotalElements: number = 0;

  constructor(private orderHistoryService:OrderHistoryService){}


  ngOnInit(){
    this.handleOrderHistory();
  }


  handleOrderHistory(){

    // read the user's email address from browser storage
    const theEmail = JSON.parse(this.storage.getItem('userEmail')!);

    console.log(`your email is: ${theEmail}`)

    // retrieve data from the service
    this.orderHistoryService.getOrderHistory(theEmail,
                                             this.thePageNumber - 1,
                                             this.thePageSize).subscribe(res =>{
        console.log(res.content)
        this.orderHistoryList = res.content;
        this.thePageNumber = res.number + 1;
        this.thePageSize = res.size;
        this.theTotalElements = res.totalElements;
    })

  }



}
