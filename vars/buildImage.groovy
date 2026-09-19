def call(String imageName,String imageVersion){
  docker build -t "${imageName}":"${imageVersion}" .
}
