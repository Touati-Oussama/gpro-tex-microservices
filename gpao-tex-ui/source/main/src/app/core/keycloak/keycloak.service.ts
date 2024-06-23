import {Injectable} from '@angular/core';
import {User} from '@core/models/user';
import Keycloak from 'keycloak-js';

@Injectable({
  providedIn: 'root'
})
export class KeycloakService {
  private _keycloak: Keycloak | undefined;
  get keycloak() {
    if (!this._keycloak) {
      this._keycloak = new Keycloak({
        url: 'http://localhost:8080/',
        realm: 'gpao-realm',
        clientId: 'gpao-client',
      });
    }
    return this._keycloak
  }

  constructor() {
  }

  private _userProfile: User | undefined

  get profile(): User | undefined {
    return this._userProfile;
  }

  async init() {
    console.log("Authentification user");
    const authenticated = await this.keycloak.init({
      onLoad: 'login-required',
    });
    if (authenticated) {
      if (this._keycloak?.token) {
        const token = this._keycloak?.token;
        const tokenJson = JSON.stringify(token);
        localStorage.setItem('access_token', tokenJson);
      }

      this._userProfile = (await this.keycloak.loadUserProfile()) as User;
      this._userProfile.token = this.keycloak.token || '';
      const username = this._userProfile.username;
      if (username) {
        localStorage.setItem('username', username);
      }
      if (this._keycloak?.tokenParsed?.resource_access) {
        const roles = this._keycloak.tokenParsed.resource_access?.[this.keycloak.clientId || '']?.roles;
        if (roles) {
          const rolesJson = JSON.stringify(roles);
          localStorage.setItem('keycloak_roles', rolesJson);
        }
      }
    }
  }

  login() {
    return this.keycloak.login();
  }

  logout() {
    return this.keycloak.logout({redirectUri: 'http://localhost:4200'});
  }

  accountManagement() {
    return this.keycloak.accountManagement();
  }

}
