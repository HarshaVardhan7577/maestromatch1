import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginAsTeacherComponent } from './login-as-teacher.component';

describe('LoginAsTeacherComponent', () => {
  let component: LoginAsTeacherComponent;
  let fixture: ComponentFixture<LoginAsTeacherComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LoginAsTeacherComponent]
    });
    fixture = TestBed.createComponent(LoginAsTeacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
