import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CouresListComponent } from './coures-list.component';

describe('CouresListComponent', () => {
  let component: CouresListComponent;
  let fixture: ComponentFixture<CouresListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CouresListComponent]
    });
    fixture = TestBed.createComponent(CouresListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
