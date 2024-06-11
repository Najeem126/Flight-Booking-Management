import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'flightbookingsystem';


  cname:string="head";
  d:string=new Date().toLocaleDateString();
  t:string=new Date().toLocaleTimeString();

  timeid=setInterval(()=>{
    this.t=new Date().toLocaleTimeString();
  },1000)

  isDisabled:boolean=false;

  myStyle:object={
    color:'grey',
    background:'white',
    border:'1px solid cyan',
  }

  counter:number=0;
  increment(){
    this.counter+=1;
  }
  decrement(){
    this.counter-=1;
  }

  name="";
  ChangeName(e:any){
    this.name=e.target.value;
  }

  city="Hyderabad";
}
