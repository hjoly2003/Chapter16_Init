Hi, while running the code chapter 16, I'm experiencing problems with the `test-em-all.bash` script when it is running in a Kubernetes cluster.

I was trying to reproduce what you did in the section "Deploying to Kubernetes for development and test". My version can be found on GitHub at the following URL: [Chapter16_init](https://github.com/hjoly2003/Chapter16_Init).  Since I have a Mac M1, I had to adapt your version of the project (See the ["arm64" bullet](https://github.com/hjoly2003/Chapter16_Init/blob/master/README.md#arm64_id) in the README.md file). A detailed description of the steps that I did can be found in the section [Deploying to Kubernetes for development and test](https://github.com/hjoly2003/Chapter16_Init/blob/master/README.md#deploy_and_test_id) of the same README.md file.

First, I started a cluster inspired by what you did in chapter 15, but without *ingress* and the *metric-server* (see [Develop, build and deploy microservices on Apple silicon (ARM64) | Callista](https://callistaenterprise.se/blogg/teknik/2022/11/02/microservices-on-apple-silicon/)).  

Then, for gradle to build successfully, I had to skip the unit tests since some tests were failing (see the ["gradle build" bullet](https://github.com/hjoly2003/Chapter16_Init/blob/master/README.md#unit_tests_id)). Note that if I run `gradle build` outside of the minikube environment, they all pass.  

I was able to follow your instructions without problem up to the `test_em_all.sh` script. When I start the script, it waits for ever for a response from the actuator health. 
```
Start Tests: Ven 27 jan 2023 07:22:53 EST
HOST=192.168.67.2
PORT=30443
USE_K8S=true
SKIP_CB_TESTS=false
Wait for: curl -k https://192.168.67.2:30443/actuator/health... , retry #1 , retry #2 , retry #3 , retry #4 , retry #5 , retry #6 , retry #7 , retry #8
```
Note that I have the same problem if I use a plain minikube cluster (i.e. via `minikube start`).

I hope that in my GitHub repository, you'll find everything you need to diagnose the problem.

Finally, I'd like to thank you for your book. So far, it is the most complete reference on the subject and I would recommend it to everyone.

Thanks in advance,

Hugues Joly