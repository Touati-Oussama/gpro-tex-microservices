import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCouleurComponent } from './add-couleur.component';

describe('AddCouleurComponent', () => {
  let component: AddCouleurComponent;
  let fixture: ComponentFixture<AddCouleurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddCouleurComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddCouleurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
