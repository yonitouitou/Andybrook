import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoggedUsersComponent } from './logged-users.component';

describe('LoggedUsersComponent', () => {
  let component: LoggedUsersComponent;
  let fixture: ComponentFixture<LoggedUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoggedUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoggedUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
