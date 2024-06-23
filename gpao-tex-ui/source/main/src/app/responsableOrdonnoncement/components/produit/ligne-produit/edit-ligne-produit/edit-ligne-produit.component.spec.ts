import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditLigneProduitComponent } from './edit-ligne-produit.component';

describe('EditLigneProduitComponent', () => {
  let component: EditLigneProduitComponent;
  let fixture: ComponentFixture<EditLigneProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditLigneProduitComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditLigneProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
