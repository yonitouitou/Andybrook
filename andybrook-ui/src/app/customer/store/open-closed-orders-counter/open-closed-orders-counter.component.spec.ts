import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenClosedOrdersCounterComponent } from './open-closed-orders-counter.component';

describe('OpenClosedOrdersCounterComponent', () => {
  let component: OpenClosedOrdersCounterComponent;
  let fixture: ComponentFixture<OpenClosedOrdersCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpenClosedOrdersCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpenClosedOrdersCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
