import { TestBed } from '@angular/core/testing';

import { LocalStorageAuthService } from './local-storage-auth.service';

describe('AuthService', () => {
  let service: LocalStorageAuthService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LocalStorageAuthService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
