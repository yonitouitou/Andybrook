import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StockReportHeaderComponent } from './show-order-header.component';

describe('StockReportHeaderComponent', () => {
  let component: StockReportHeaderComponent;
  let fixture: ComponentFixture<StockReportHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StockReportHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StockReportHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
