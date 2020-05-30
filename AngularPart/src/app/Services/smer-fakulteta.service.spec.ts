import { TestBed } from '@angular/core/testing';

import { SmerFakultetaService } from './smer-fakulteta.service';

describe('SmerFakultetaService', () => {
  let service: SmerFakultetaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SmerFakultetaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
