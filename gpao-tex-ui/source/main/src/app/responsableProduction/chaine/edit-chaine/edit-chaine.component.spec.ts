import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditChaineComponent } from './edit-chaine.component';

describe('EditChaineComponent', () => {
  let component: EditChaineComponent;
  let fixture: ComponentFixture<EditChaineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditChaineComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditChaineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
