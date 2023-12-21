import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChatboatIconComponent } from './chatboat-icon.component';

describe('ChatboatIconComponent', () => {
  let component: ChatboatIconComponent;
  let fixture: ComponentFixture<ChatboatIconComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ChatboatIconComponent]
    });
    fixture = TestBed.createComponent(ChatboatIconComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
