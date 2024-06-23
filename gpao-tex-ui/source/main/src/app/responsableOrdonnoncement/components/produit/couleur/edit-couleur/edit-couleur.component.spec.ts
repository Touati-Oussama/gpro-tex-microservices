import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCouleurComponent } from './edit-couleur.component';

describe('EditCouleurComponent', () => {
  let component: EditCouleurComponent;
  let fixture: ComponentFixture<EditCouleurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditCouleurComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditCouleurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
