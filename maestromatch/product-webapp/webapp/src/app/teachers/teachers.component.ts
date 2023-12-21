import { NgZone} from '@angular/core';
import { ChangeDetectorRef } from '@angular/core';
import { Component, ViewChild, TemplateRef } from '@angular/core';
import { RestServiceService } from '../rest-service.service';
import { Teacher } from './teacher';
import {PageEvent} from '@angular/material/paginator';
import { Router } from '@angular/router';
import {MatPaginator} from '@angular/material/paginator';
@Component({
  selector: 'app-teachers',
  templateUrl: './teachers.component.html',
  styleUrls: ['./teachers.component.css']
})
export class TeachersComponent {
  constructor(private zone: NgZone, private rs: RestServiceService, private cdr: ChangeDetectorRef, private route: Router) {}
  // numbers: number[] = [1, 2, 3,4];
  teacher:Teacher=new Teacher();
  recommendationArray: Teacher []=[]; 
  productsList: Teacher[]= [];
  searchtxt : string ='';
    nameCheckbox: boolean = false;
    instrumentCheckbox:  boolean =false;
    locationCheckbox: boolean = false;
  
    
    length: number = 0;
    pageSize = 6;
   
    pageSizeOptions = [6, 12];
  
    hidePageSize = false;
    showPageSizeOptions = true;
    showFirstLastButtons = true;
    disabled = false;
  
    pageEvent!: PageEvent;
  
    handlePageEvent(e: PageEvent) {
      
      
      let startIndex = e.pageIndex * e.pageSize;
      let endIndex = startIndex + e.pageSize;
      if(endIndex > this.length){
        endIndex = this.length;
      }
      this.recommendationArray = this.productsList.slice(startIndex, endIndex);
    }
  
   

    ngOnInit(): void{
      this.rs.getRecommendations().subscribe((response)=>{
        this.zone.run(()=>{
          this.productsList=response;
          this.length = this.productsList.length;
          if(this.length>this.pageSize){
            this.pageSize=this.length/2;
            if(this.pageSize<6){
              this.pageSize=6;
            }
          }
          this.updateRecommendationArray(0);
        })
      });
      
      
    }

    onSubmit(){
      
      if(this.searchtxt.length==0){
        this.rs.getRecommendations().subscribe(
          data=>{
            this.productsList = data;
            this.length = this.productsList.length;

            this.updateRecommendationArray(0);
          },
          error=>{
            console.log(error);
          }
        )
      }
      else{

      console.log(this.searchtxt.length);
        if(this.instrumentCheckbox)
        {
          this.rs.getByInstrument(this.searchtxt).subscribe(
            data=>{
              this.productsList = data;
              this.length = this.productsList.length;
              if(this.length>this.pageSize){
                this.pageSize=this.length/2;}
              
                if(this.length<6){
                  this.pageSize=this.length;
                
                
              }
              this.updateRecommendationArray(0);
              console.log("working");
            },
            error=>{
              console.log(error);
            }
          )
        }
        if(this.nameCheckbox)
        {
          this.rs.getByName(this.searchtxt).subscribe(
            data=>{
              this.productsList = data;
              this.length = this.productsList.length;
              if(this.length>this.pageSize){
                this.pageSize=this.length/2;}
              
                if(this.length<6){
                  this.pageSize=this.length;
                }
                
             
              this.updateRecommendationArray(0);
            },
            error=>{
              console.log(error);
            }
          )
        }
        if(this.locationCheckbox)
        {
          this.rs.getByLocation(this.searchtxt).subscribe(
            data=>{
              this.productsList = data;
              this.length = this.productsList.length;
              if(this.length>this.pageSize){
                this.pageSize=this.length/2;}
              
                if(this.length<6){
                  this.pageSize=this.length;
                }
                
             
              this.updateRecommendationArray(0);
            },
            error=>{
              console.log(error);
            }
          )
        }
  
        if (this.nameCheckbox && this.instrumentCheckbox) {
          // Code for both "name" and "instrument" checkboxes selected
          this.rs.getByNameAndInstrument(this.searchtxt).subscribe(
            (data) => {
              this.productsList = data;
              this.length = this.productsList.length;
              if(this.length>this.pageSize){
                this.pageSize=this.length/2;}
              
                if(this.length<6){
                  this.pageSize=this.length;
                }
                
            
              this.updateRecommendationArray(0);
            },
            (error) => {
              console.log(error);
            }
          );
        }
      
        if (this.nameCheckbox && this.locationCheckbox) {
          // Code for both "name" and "location" checkboxes selected
          this.rs.getByNameAndLocation(this.searchtxt).subscribe(
            (data) => {
              this.productsList = data;
              this.length = this.productsList.length;
              if(this.length>this.pageSize){
                this.pageSize=this.length/2;}
            
                if(this.length<6){
                  this.pageSize=this.length;
                }
                
           
              this.updateRecommendationArray(0);
            },
            (error) => {
              console.log(error);
            }
          );
        }
      
        if (this.instrumentCheckbox && this.locationCheckbox) {
          // Code for both "instrument" and "location" checkboxes selected
          this.rs.getByInstrumentAndLocation(this.searchtxt).subscribe(
            (data) => {
              this.productsList = data;
              this.length = this.productsList.length;
              if(this.length>this.pageSize){
                this.pageSize=this.length/2;}
             
                if(this.length<6){
                  this.pageSize=this.length;
                }
                
            
              this.updateRecommendationArray(0);
            },
            (error) => {
              console.log(error);
            }
          );
        }
        else{
          this.rs.getByName(this.searchtxt).subscribe(
            (data) => {
              this.productsList = data;
              this.length = this.productsList.length;
              if(this.length>this.pageSize){
                this.pageSize=this.length/2;}
             
                if(this.length<6){
                  this.pageSize=this.length;
                }
                
           
              this.updateRecommendationArray(0);
            },
            (error) => {
              console.log(error);
            }
          );
        }
      }
      
      // this.updateRecommendationArray(0);
      this.cdr.detectChanges();
    }
    updateRecommendationArray(pageIndex: number){
      const startIndex = pageIndex * this.pageSize;
      const endIndex = Math.min(startIndex + this.pageSize, this.length);
      this.recommendationArray = this.productsList.slice(startIndex, endIndex);
      console.log("inside update");
    }

    onBook(teacherId:number ){
      this.route.navigate(['booking',teacherId]);
    }
  
}
