import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeacherEditDialogComponent } from './teacher-edit-dialog.component';

describe('TeacherEditDialogComponent', () => {
  let component: TeacherEditDialogComponent;
  let fixture: ComponentFixture<TeacherEditDialogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TeacherEditDialogComponent]
    });
    fixture = TestBed.createComponent(TeacherEditDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
