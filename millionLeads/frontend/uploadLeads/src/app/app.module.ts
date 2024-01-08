import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { UploadLeadsComponent } from './components/upload-leads/upload-leads.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { NgxUiLoaderModule, NgxUiLoaderHttpModule } from "ngx-ui-loader";

@NgModule({
  declarations: [
    AppComponent,
    UploadLeadsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    NgbModule,
    HttpClientModule,
    NgxUiLoaderModule,
    NgxUiLoaderHttpModule.forRoot({ showForeground: true })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
