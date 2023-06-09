import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFavoritesComponent } from './user-favorites.component';

describe('UserFavoritesComponent', () => {
  let component: UserFavoritesComponent;
  let fixture: ComponentFixture<UserFavoritesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserFavoritesComponent]
    });
    fixture = TestBed.createComponent(UserFavoritesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
