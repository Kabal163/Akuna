import { AkunaPage } from './app.po';

describe('akuna App', () => {
  let page: AkunaPage;

  beforeEach(() => {
    page = new AkunaPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
