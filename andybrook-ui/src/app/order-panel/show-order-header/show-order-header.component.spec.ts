import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderHeaderComponent } from './show-order-header.component';

describe('OrderHeaderComponent', () => {
  let component: OrderHeaderComponent;
  let fixture: ComponentFixture<OrderHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
