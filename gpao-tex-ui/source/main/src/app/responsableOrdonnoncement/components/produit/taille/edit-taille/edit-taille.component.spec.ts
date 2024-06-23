import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditTailleComponent } from './edit-taille.component';

describe('EditTailleComponent', () => {
  let component: EditTailleComponent;
  let fixture: ComponentFixture<EditTailleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditTailleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditTailleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
