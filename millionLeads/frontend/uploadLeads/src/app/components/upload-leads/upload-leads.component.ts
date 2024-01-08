import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-upload-leads',
  templateUrl: './upload-leads.component.html',
  styleUrls: ['./upload-leads.component.css']
})
export class UploadLeadsComponent {
  constructor(private http : HttpClient ){}



  apiCall(){
    //alert("hi");
    this.http.post(`http://localhost:8080/api/readCSVFile`,{}).subscribe((response)=>{},(error)=>{});
  }
}
