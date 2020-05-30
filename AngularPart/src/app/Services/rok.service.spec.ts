import { TestBed } from '@angular/core/testing';

import { RokService } from './rok.service';

describe('RokService', () => {
  let service: RokService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RokService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
