import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderNotificationModalComponent } from './order-notification-modal.component';

describe('OrderNotificationModalComponent', () => {
  let component: OrderNotificationModalComponent;
  let fixture: ComponentFixture<OrderNotificationModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderNotificationModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderNotificationModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
