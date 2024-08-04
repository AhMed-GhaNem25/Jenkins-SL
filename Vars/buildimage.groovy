#!/usr/bin/env groovy
def call() {

    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t ghanemovic/jenkins-task:jm-3.0 .'
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh 'docker push ghanemovic/jenkins-task:jm-3.0'
    }
}