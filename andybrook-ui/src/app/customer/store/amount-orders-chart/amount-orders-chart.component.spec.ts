import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AmountOrdersChartComponent } from './amount-orders-chart.component';

describe('AmountOrdersChartComponent', () => {
  let component: AmountOrdersChartComponent;
  let fixture: ComponentFixture<AmountOrdersChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AmountOrdersChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AmountOrdersChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
