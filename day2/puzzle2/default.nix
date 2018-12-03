with import <nixpkgs> {};
stdenv.mkDerivation {
  name = "javascript-sandbox";
  buildInputs = [
    pkgs.nodejs-8_x
  ];
    shellHook = ''
        export PATH="$PATH:$(pwd)/node_modules/.bin"
        '';
}
