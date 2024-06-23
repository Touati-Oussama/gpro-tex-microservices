import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSousFamilleProduitComponent } from './edit-sous-famille-produit.component';

describe('EditSousFamilleProduitComponent', () => {
  let component: EditSousFamilleProduitComponent;
  let fixture: ComponentFixture<EditSousFamilleProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditSousFamilleProduitComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditSousFamilleProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
