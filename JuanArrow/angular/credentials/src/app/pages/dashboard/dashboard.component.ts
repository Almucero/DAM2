import { Component, computed, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { LocalStorageAuthService } from '../../core/services/local-storage-auth.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent {
  private auth = inject(LocalStorageAuthService);
  private router = inject(Router);

  user = computed(() => this.auth.user());

  onLogout() {
    this.auth.logout();
    this.router.navigate(['/login']);
  }
}
