<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Badwords
 *
 * @ORM\Table(name="badwords")
 * @ORM\Entity
 */
class Badwords
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_badwords", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idBadwords;

    /**
     * @var string
     *
     * @ORM\Column(name="badword", type="string", length=100, nullable=false)
     */
    private $badword;



    /**
     * Get idBadwords
     *
     * @return integer
     */
    public function getIdBadwords()
    {
        return $this->idBadwords;
    }

    /**
     * Set badword
     *
     * @param string $badword
     *
     * @return Badwords
     */
    public function setBadword($badword)
    {
        $this->badword = $badword;

        return $this;
    }

    /**
     * Get badword
     *
     * @return string
     */
    public function getBadword()
    {
        return $this->badword;
    }
}
