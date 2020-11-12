import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {NavigationComponent} from './navigation/navigation.component';
import {FooterComponent} from './footer/footer.component';
import {HomeComponent} from './home/home.component';
import {ContactComponent} from './contact/contact.component';
import {AboutComponent} from './about/about.component';
import {RouterModule, Routes} from "@angular/router";
import {BreadcrumbModule} from "xng-breadcrumb";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {ConsultComponent} from './consult/consult.component';
import {BookingComponent} from './booking/booking.component';
import {PaymentComponent} from './payment/payment.component';
import {TestimonialComponent} from './testimonial/testimonial.component';
import {MainComponent} from "./blog/main/main.component";
import {BlogModule, routes as blogRoutes} from "./blog/blog.module";
import { VerifyComponent } from './verify/verify.component';

const routes: Routes = [
  {path: '', component: HomeComponent, data: {breadcrumb: 'Home'}},
  {path: 'about', component: AboutComponent, data: {breadcrumb: 'About'}},
  {path: 'contact', component: ContactComponent, data: {breadcrumb: 'Contact'}},
  {path: 'consult', component: ConsultComponent, data: {breadcrumb: 'Consultation'}},
  {path: 'booking/:id', component: BookingComponent, data: {breadcrumb: 'Booking'}},
  {path: 'payment', component: PaymentComponent, data: {breadcrumb: 'Payment'}},
  {path: 'testimonial', component: TestimonialComponent, data: {breadcrumb: 'Testimonials'}},
  {path: 'blogs', component: MainComponent, children: blogRoutes, data: {skip: true}},
  {path: 'verify/:code', component: VerifyComponent, data: {breadcrumb: 'Verification'}}
]

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    FooterComponent,
    HomeComponent,
    ContactComponent,
    AboutComponent,
    ConsultComponent,
    BookingComponent,
    PaymentComponent,
    TestimonialComponent,
    VerifyComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    BreadcrumbModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    BlogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule
{
}
