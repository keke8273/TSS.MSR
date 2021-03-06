package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This structure contains the Name and hash of the contents of the selected NV Index
 *  that is certified by TPM2_NV_Certify(). The data is hashed using hash of the signing scheme.
 */
public class TPMS_NV_DIGEST_CERTIFY_INFO extends TpmStructure implements TPMU_ATTEST
{
    /** Name of the NV Index  */
    public byte[] indexName;
    
    /** Hash of the contents of the index  */
    public byte[] nvDigest;
    
    public TPMS_NV_DIGEST_CERTIFY_INFO() {}
    
    /** @param _indexName Name of the NV Index
     *  @param _nvDigest Hash of the contents of the index
     */
    public TPMS_NV_DIGEST_CERTIFY_INFO(byte[] _indexName, byte[] _nvDigest)
    {
        indexName = _indexName;
        nvDigest = _nvDigest;
    }
    
    /** TpmUnion method  */
    public TPM_ST GetUnionSelector() { return TPM_ST.ATTEST_NV_DIGEST; }
    
    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeSizedByteBuf(indexName);
        buf.writeSizedByteBuf(nvDigest);
    }
    
    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _indexNameSize = buf.readShort() & 0xFFFF;
        indexName = new byte[_indexNameSize];
        buf.readArrayOfInts(indexName, 1, _indexNameSize);
        int _nvDigestSize = buf.readShort() & 0xFFFF;
        nvDigest = new byte[_nvDigestSize];
        buf.readArrayOfInts(nvDigest, 1, _nvDigestSize);
    }
    
    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.buffer();
    }
    
    public static TPMS_NV_DIGEST_CERTIFY_INFO fromBytes (byte[] byteBuf) 
    {
        TPMS_NV_DIGEST_CERTIFY_INFO ret = new TPMS_NV_DIGEST_CERTIFY_INFO();
        InByteBuf buf = new InByteBuf(byteBuf);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static TPMS_NV_DIGEST_CERTIFY_INFO fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    public static TPMS_NV_DIGEST_CERTIFY_INFO fromTpm (InByteBuf buf) 
    {
        TPMS_NV_DIGEST_CERTIFY_INFO ret = new TPMS_NV_DIGEST_CERTIFY_INFO();
        ret.initFromTpm(buf);
        return ret;
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPMS_NV_DIGEST_CERTIFY_INFO");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "byte", "indexName", indexName);
        _p.add(d, "byte", "nvDigest", nvDigest);
    }
}

//<<<
