/* global HTMLElement */

export class AlterEgo extends HTMLElement {
  connectedCallback () {
    console.log('AlerEgo script works!')
    this.secretIdentity = this.getAttribute('data-secret-identity')
    console.log('Secret Identity: ' + this.secretIdentity)
    this.init()
  }

  init () {
    console.log('Alter ego Init secret identity: ' + this.secretIdentity)
  }
}
