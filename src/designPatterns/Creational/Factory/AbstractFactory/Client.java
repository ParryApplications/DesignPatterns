package designPatterns.Creational.Factory.AbstractFactory;

public class Client {


    public static void main(String[] args) {

        //AWS Resource
        AbstractFactory awsResource = new AWSResource();
        Instance Ec2Instance = awsResource.getInstance();
        Storage S3Storage = awsResource.getStorage();

        S3Storage.createStorage(2);
        Ec2Instance.attachedStorage(S3Storage.capacityInMb);
        Ec2Instance.instanceRunning();
        Ec2Instance.instanceStopping();


        GoogleResource googleResource = new GoogleResource();
        Instance GoogleEngineStorage = googleResource.getInstance();
        Storage GcsStorage = googleResource.getStorage();

        GcsStorage.createStorage(4);
        GoogleEngineStorage.attachedStorage(GcsStorage.capacityInMb);
        GoogleEngineStorage.instanceRunning();
        GoogleEngineStorage.instanceStopping();
    }
}
