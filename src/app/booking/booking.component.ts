import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Customer} from "../entity/Customer.model";
import {ConsultationService} from "../services/consultation.service";
import {Product} from "../entity/Product.model";

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit
{
  id: number

  productForm: FormGroup;
  firstName: AbstractControl;
  lastName: AbstractControl;
  dob: AbstractControl;
  email: AbstractControl;
  subject: AbstractControl;
  countryCode: AbstractControl;
  phone: AbstractControl;
  productSubmitFlag = false;

  selectedProduct: Product;

  options: Array<Product> = [new Product(1, '30', 'Phone Call', 2999),
    new Product(2, '60', 'Phone Call', 4999),
    new Product(3, '90', 'Phone Call', 7999),
    new Product(4, '30', 'Video Call', 7999),
    new Product(5, '60', 'Video Call', 10999),
    new Product(6, '90', 'Video Call', 14999)];

  constructor(private activatedRoute: ActivatedRoute, fb: FormBuilder, private route: Router, private consultationService: ConsultationService)
  {
    this.activatedRoute.params.subscribe(params =>
    {
      this.id = params['id'];
      this.selectedProduct = this.options.find(prod => prod.id == this.id);
    });
    this.productForm = fb.group({
      firstName: ['', [Validators.required, this.noWhitespaceValidator]],
      lastName: ['', [Validators.required, this.noWhitespaceValidator]],
      dob: [null, [Validators.required, this.noWhitespaceValidator]],
      email: ['', [Validators.required, this.noWhitespaceValidator]],
      subject: ['', [Validators.required, this.noWhitespaceValidator]],
      countryCode: ['', Validators.required],
      phone: ['', [Validators.required, this.noWhitespaceValidator]],
    });

    this.firstName = this.productForm.controls.firstName;
    this.lastName = this.productForm.controls.lastName;
    this.dob = this.productForm.controls.dob;
    this.email = this.productForm.controls.email;
    this.subject = this.productForm.controls.subject;
    this.countryCode = this.productForm.controls.countryCode;
    this.phone = this.productForm.controls.phone;
  }

  ngOnInit(): void
  {
  }

  onSubmit(customer: Customer)
  {
    this.selectedProduct.id=null;
    customer.product = this.selectedProduct;
    this.consultationService.consult(customer)
      .subscribe(value =>
      {
        console.log(value);
        this.route.navigateByUrl('/payment');
      });
  }

  private noWhitespaceValidator(control: FormControl)
  {
    const isWhitespace = (control.value || '').trim().length === 0;
    const isValid = !isWhitespace;
    return isValid ? null : {whitespace: true};
  }

}
