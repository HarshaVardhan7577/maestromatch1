import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRefMatComponent } from './create-ref-mat.component';

describe('CreateRefMatComponent', () => {
  let component: CreateRefMatComponent;
  let fixture: ComponentFixture<CreateRefMatComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateRefMatComponent]
    });
    fixture = TestBed.createComponent(CreateRefMatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
