import { TestBed } from '@angular/core/testing';

import { RefMatService } from './ref-mat.service';

describe('RefMatService', () => {
  let service: RefMatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RefMatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
