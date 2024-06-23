import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSousFamilleProduitComponent } from './add-sous-famille-produit.component';

describe('AddSousFamilleProduitComponent', () => {
  let component: AddSousFamilleProduitComponent;
  let fixture: ComponentFixture<AddSousFamilleProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddSousFamilleProduitComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddSousFamilleProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
