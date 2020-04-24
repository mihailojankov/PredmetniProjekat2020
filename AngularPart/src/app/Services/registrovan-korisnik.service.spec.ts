import { TestBed } from '@angular/core/testing';

import { RegistrovanKorisnikService } from './registrovan-korisnik.service';

describe('RegistrovanKorisnikService', () => {
  let service: RegistrovanKorisnikService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistrovanKorisnikService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
