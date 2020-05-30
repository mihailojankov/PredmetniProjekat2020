import { TestBed } from '@angular/core/testing';

import { IshodIspitaService } from './ishod-ispita.service';

describe('IshodIspitaService', () => {
  let service: IshodIspitaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IshodIspitaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
