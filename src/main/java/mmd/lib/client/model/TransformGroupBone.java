package mmd.lib.client.model;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * The PositionTransformGroup class adds a class which allows for vertex transformations.
 * @author GaryCXJk
 *
 */
@SideOnly(Side.CLIENT)
public class TransformGroupBone extends TransformGroup
{
	public TransformGroupBone(Bone bone, double wght)
	{
		baseVector = bone.getPosition();
		baseAngles = bone.getAbsoluteAngle();
		attachedBone = bone;
		weight = wght;
	}
	
	public Angle3D getBaseAngles()
	{
		return baseAngles.copy();
	}
	
	public Angle3D getTransformAngle()
	{
		Angle3D returnAngle = attachedBone.getAbsoluteAngle().copy();
		returnAngle.angleX-= baseAngles.angleX;
		returnAngle.angleY-= baseAngles.angleY;
		returnAngle.angleZ-= baseAngles.angleZ;
		return returnAngle;
	}
	
	public Vec3d getBaseVector()
	{
		return new Vec3d(baseVector.xCoord, baseVector.yCoord, baseVector.zCoord);
	}
	
	public Vec3d getTransformVector()
	{
		return baseVector.subtract(attachedBone.getPosition());
	}
	
	public Vec3d getCurrentVector()
	{
		return attachedBone.getPosition();
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public void attachBone(Bone bone)
	{
		baseVector = bone.getPosition();
		baseAngles = bone.getAbsoluteAngle();
		attachedBone = bone;
	}
	
	public Vec3d doTransformation(PositionTransformVertex vertex)
	{
		Vec3d vector = new Vec3d(vertex.neutralVector.xCoord, vertex.neutralVector.yCoord, vertex.neutralVector.zCoord);
		vector = getBaseVector().subtract(vector);
		Angle3D angle = getTransformAngle();
		setVectorRotations(vector, angle.angleX, angle.angleY, angle.angleZ);
		
		return vector;
	}
	
	protected void setVectorRotations(Vec3d vector, float xRot, float yRot, float zRot)
	{
		float x = xRot;
		float y = yRot;
		float z = zRot;
        float xC = MathHelper.cos(x);
        float xS = MathHelper.sin(x);
        float yC = MathHelper.cos(y);
        float yS = MathHelper.sin(y);
        float zC = MathHelper.cos(z);
        float zS = MathHelper.sin(z);
        
        double xVec = vector.xCoord;
        double yVec = vector.yCoord;
        double zVec = vector.zCoord;
        
        // rotation around x
		double xy = xC*yVec - xS*zVec;
		double xz = xC*zVec + xS*yVec;
		// rotation around y
		double yz = yC*xz - yS*xVec;
		double yx = yC*xVec + yS*xz;
		// rotation around z
		double zx = zC*yx - zS*xy;
		double zy = zC*xy + zS*yx;
		
		xVec = zx;
		yVec = zy;
		zVec = yz;
		
        /*vector.xCoord = xVec;
        vector.yCoord = yVec;
        vector.zCoord = zVec;*/
		vector = new Vec3d(xVec, yVec, zVec);
	}
	
	protected Angle3D baseAngles;
	protected Vec3d baseVector;
	protected Bone attachedBone;
	protected double weight;
}
