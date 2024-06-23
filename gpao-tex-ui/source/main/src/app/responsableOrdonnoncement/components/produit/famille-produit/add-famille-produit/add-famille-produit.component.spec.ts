import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFamilleProduitComponent } from './add-famille-produit.component';

describe('AddFamilleProduitComponent', () => {
  let component: AddFamilleProduitComponent;
  let fixture: ComponentFixture<AddFamilleProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddFamilleProduitComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddFamilleProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
