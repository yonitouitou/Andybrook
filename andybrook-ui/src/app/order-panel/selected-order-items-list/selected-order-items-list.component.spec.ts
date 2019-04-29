import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectedOrderItemsListComponent } from './selected-order-items-list.component';

describe('SelectedOrderItemsListComponent', () => {
  let component: SelectedOrderItemsListComponent;
  let fixture: ComponentFixture<SelectedOrderItemsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectedOrderItemsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectedOrderItemsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
