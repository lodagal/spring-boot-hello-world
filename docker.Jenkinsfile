pipeline {
  agent any
  environment {
        registry = "vsiraparapu/hello-world"
        registryCredential = 'docker-hub-jenkins-creds'
        dockerImage = ''
    }
  stages {
   
    stage('Build-Code'){
        steps {
            script {
                sh "mvn install"
            }
        }
    }
    stage('Building our image') {
        steps{
            script {
                dockerImage = docker.build registry + ":latest"
            }
        }
    }
    stage('Push Registry') {
        steps{
            script {
                docker.withRegistry( '', registryCredential ) {
                    dockerImage.push()
               }
            }
        }
    }
    stage('Deploy k8s') {
        steps{
            script {
                sh """
                    export KUBECONFIG=~/.kube/config
                    kubectl config get-contexts
                    kubectl config use-context kubernetes-admin@kubernetes
                   kubectl apply -f deploy-k8s/hello-world-deploy.yaml
                   kubectl apply -f deploy-k8s/hello-world-svc.yaml
                """
            }
        }
    }
    // stage('imageBuild'){
    //     steps {
    //         script {
    //             sh "docker build -t vsiraparapu/hello-world:latest ."
    //         }
    //     }
    // }
    // stage('pushImageRegistry'){
    //     steps {
    //         script {
    //             sh """
    //               docker login -u vsiraparapu -p dckr_pat_d2Ze8mBpKEfPeVQMsF__XH_-ynI
    //               docker push vsiraparapu/hello-world:latest
    //               docker tag vsiraparapu/hello-world:latest vsiraparapu/hello-world:${BUILD_NUMBER}-slim-bullseye
    //               docker push vsiraparapu/hello-world:${BUILD_NUMBER}-slim-bullseye
    //               docker rmi vsiraparapu/hello-world:${BUILD_NUMBER}-slim-bullseye
    //             """
    //         }
    //     }
    // }

  }
  post {
        always {
             cleanWs()
        }
    }
}