import { TestBed } from '@angular/core/testing';

import { PrijavaIspitaService } from './prijava-ispita.service';

describe('PrijavaIspitaService', () => {
  let service: PrijavaIspitaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PrijavaIspitaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
