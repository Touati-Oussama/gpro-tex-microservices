import { RouteInfo } from './sidebar.metadata';
export const ROUTES: RouteInfo[] = [
  {
    path: '',
    title: 'MENUITEMS.MAIN.TEXT',
    iconType: '',
    icon: '',
    class: '',
    groupTitle: true,
    badge: '',
    badgeClass: '',
    role: ['All'],
    submenu: [],
  },

  // Admin Modules
  {
    path: '',
    title: 'MENUITEMS.DASHBOARD.TEXT',
    iconType: 'feather',
    icon: 'monitor',
    class: 'menu-toggle',
    groupTitle: false,
    badge: '',
    badgeClass: '',
    role: ['Admin'],
    submenu: [
      {
        path: '/admin/dashboard/main',
        title: 'MENUITEMS.DASHBOARD.LIST.DASHBOARD1',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
    ],
  },
  {
    path: '',
    title: 'MENUITEMS.SITE.TEXT',
    iconType: 'feather',
    icon: 'map-pin',
    class: 'menu-toggle',
    groupTitle: false,
    badge: '',
    badgeClass: '',
    role: ["Admin"],
    submenu: [
      {
        path: '/admin/site/all-site',
        title: 'Liste des sites',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
    ]
  },
  {
    path: '',
    title: 'MENUITEMS.PRODUIT.TEXT',
    iconType: 'feather',
    icon: 'package',
    class: 'menu-toggle',
    groupTitle: false,
    badge: '',
    badgeClass: '',
    role: ['Responsable_commercial', "Admin"],
    submenu: [
      {
        path: 'commercial/all-produit',
        title: 'Liste des produits',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
    ]
  },

  //commercial
  {
    path: '',
    title: 'MENUITEMS.PI.TEXT',
    iconType: 'feather',
    icon: 'users',
    class: 'menu-toggle',
    groupTitle: false,
    badge: '',
    badgeClass: '',
    role: ['Responsable_commercial', "Admin"],
    submenu: [
      {
        path: 'commercial/all-pi',
        title: 'Liste parties prenantes',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
    ]
  },

  //ordonnoncement
  {
    path: '',
    title: 'MENUITEMS.OF.TEXT',
    iconType: 'feather',
    icon: 'book',
    class: 'menu-toggle',
    groupTitle: false,
    badge: '',
    badgeClass: '',
    role: ['Responsable_ordonnancement', "Admin"],
    submenu: [
      {
        path: 'ordRes/of/all-Of',
        title: 'Liste des ordres',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
    ]
  },
  {
    path: '',
    title: 'MENUITEMS.REF.TEXT',
    iconType: 'feather',
    icon: 'cpu',
    class: 'menu-toggle',
    groupTitle: false,
    badge: '',
    badgeClass: '',
    role: ['Responsable_ordonnancement', "Admin"],
    submenu: [
      {
        path: 'ordRes/param-produit/go-shippement-produit/all-go-ship-prod',
        title: 'GoShippement',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
      {
        path: 'ordRes/param-produit/couleur-produit/all-couleur',
        title: 'Couleur',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
      {
        path: 'ordRes/param-produit/taille-produit/all-taille',
        title: 'Taille',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
      {
        path: 'ordRes/param-produit/theme-produit/all-theme',
        title: 'Theme',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
      {
        path: 'ordRes/param-produit/famille-produit/all-famille-prod',
        title: 'Famille',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
      {
        path: 'ordRes/param-produit/sf-produit/all-sf-prod',
        title: 'Soufamille',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
      {
        path: 'ordRes/param-produit/mesure-produit/all-mesure-prod',
        title: 'Mesure Produit',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
      {
        path: 'ordRes/param-produit/ligne-produit/all-ligne-prod',
        title: 'Ligne Produit',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
      {
        path: 'ordRes/param-produit/document/all-document',
        title: 'Documents',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
      {
        path: 'ordRes/param-produit/element/all-element-trait-prod',
        title: 'Element de traitement',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
    ]
  },

  //production
  {
    path: '',
    title: 'MENUITEMS.CHAINE.TEXT',
    iconType: 'feather',
    icon: 'link',
    class: 'menu-toggle',
    groupTitle: false,
    badge: '',
    badgeClass: '',
    role: ['Responsable_production', "Admin"],
    submenu: [
      {
        path: 'productionRes/all-chaine',
        title: 'Liste des chaines',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
    ]
  },
  {
    path: '',
    title: 'MENUITEMS.PE.TEXT',
    iconType: 'feather',
    icon: 'command',
    class: 'menu-toggle',
    groupTitle: false,
    badge: '',
    badgeClass: '',
    role: ['Responsable_production', "Admin"],
    submenu: [
      {
        path: 'productionRes/all-pilotage',
        title: 'Liste de Pilotage efficence',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
    ]
  },
  {
    path: '',
    title: 'MENUITEMS.PRODUCTION.TEXT',
    iconType: 'feather',
    icon: 'battery',
    class: 'menu-toggle',
    groupTitle: false,
    badge: '',
    badgeClass: '',
    role: ['Responsable_production', "Admin"],
    submenu: [
      {
        path: 'productionRes/production/productionJour/all-prod-jour',
        title: 'Production Jour',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
      {
        path: 'productionRes/production/productionHeure/all-prod-heure',
        title: 'Production Heure',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
      {
        path: 'productionRes/production/productionHeureDetails/all-prod-heure-details',
        title: 'Production Heure',
        iconType: '',
        icon: '',
        class: 'ml-menu',
        groupTitle: false,
        badge: '',
        badgeClass: '',
        role: [''],
        submenu: [],
      },
    ]
  },
];