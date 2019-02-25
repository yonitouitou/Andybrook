import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CloseReportModalComponent } from './close-report-modal.component';

describe('CloseReportModalComponent', () => {
  let component: CloseReportModalComponent;
  let fixture: ComponentFixture<CloseReportModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CloseReportModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CloseReportModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
