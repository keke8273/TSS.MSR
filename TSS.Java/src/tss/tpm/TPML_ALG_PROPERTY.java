package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This list is used to report on a list of algorithm attributes. It is returned in a
 *  TPM2_GetCapability().
 */
public class TPML_ALG_PROPERTY extends TpmStructure implements TPMU_CAPABILITIES
{
    /** List of properties  */
    public TPMS_ALG_PROPERTY[] algProperties;
    
    public TPML_ALG_PROPERTY() {}
    
    /** @param _algProperties List of properties  */
    public TPML_ALG_PROPERTY(TPMS_ALG_PROPERTY[] _algProperties) { algProperties = _algProperties; }
    
    /** TpmUnion method  */
    public TPM_CAP GetUnionSelector() { return TPM_CAP.ALGS; }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeObjArr(algProperties);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _count = buf.readInt();
        algProperties = new TPMS_ALG_PROPERTY[_count];
        for (int j=0; j < _count; j++) algProperties[j] = new TPMS_ALG_PROPERTY();
        buf.readArrayOfTpmObjects(algProperties, _count);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPML_ALG_PROPERTY fromBytes (byte[] byteBuf) 
    {
        TPML_ALG_PROPERTY ret = new TPML_ALG_PROPERTY();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPML_ALG_PROPERTY fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPML_ALG_PROPERTY fromTpm (InByteBuf buf) 
    {
        TPML_ALG_PROPERTY ret = new TPML_ALG_PROPERTY();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPML_ALG_PROPERTY");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPMS_ALG_PROPERTY", "algProperties", algProperties);
    }
}

//<<<
