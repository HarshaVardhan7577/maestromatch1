import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationAsTeacherComponent } from './registration-as-teacher.component';

describe('RegistrationAsTeacherComponent', () => {
  let component: RegistrationAsTeacherComponent;
  let fixture: ComponentFixture<RegistrationAsTeacherComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegistrationAsTeacherComponent]
    });
    fixture = TestBed.createComponent(RegistrationAsTeacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
