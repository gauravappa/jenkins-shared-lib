def call(String credentialsId,String imageName,String imageVersion){
  withCredentials([usernamePassword(
          credentialsId: "${credentialsId}", 
          usernameVariable: 'DOCKER_USER', 
          passwordVariable: 'DOCKER_PASS'
          )]) {
                echo "Starting Image Publishing"    
                sh "echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin"
                sh "docker tag \$imageName:\$imageVersion \$DOCKER_USER/\$imageName:\$imageVersion"
                sh "docker push  \$DOCKER_USER/\$imageName:\$imageVersion"
                echo "Completed Image Publishing"  
              }
}
